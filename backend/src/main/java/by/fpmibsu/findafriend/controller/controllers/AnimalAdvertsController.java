package by.fpmibsu.findafriend.controller.controllers;

import by.fpmibsu.findafriend.application.HandleResult;
import by.fpmibsu.findafriend.application.controller.*;
import by.fpmibsu.findafriend.application.mediatr.Mediatr;
import by.fpmibsu.findafriend.controller.AuthUtils;
import by.fpmibsu.findafriend.controller.Validation;
import by.fpmibsu.findafriend.controller.commands.animaladverts.CreateAnimalAdvertCommand;
import by.fpmibsu.findafriend.controller.queries.animalAdverts.GetAllAnimalAdvertsQuery;
import by.fpmibsu.findafriend.controller.queries.animalAdverts.GetAnimalAdvertsByShelterIdQuery;
import by.fpmibsu.findafriend.controller.queries.animalAdverts.GetAnimalAdvertQuery;
import by.fpmibsu.findafriend.controller.queries.animalAdverts.GetAnimalAdvertsByUserIdQuery;
import by.fpmibsu.findafriend.dataaccesslayer.animaladvert.AnimalAdvertDao;
import by.fpmibsu.findafriend.entity.User;

@ControllerRoute(route = "/animalAdverts")
public class AnimalAdvertsController extends Controller {
    private final Mediatr mediatr;

    public AnimalAdvertsController(Mediatr mediatr) {
        this.mediatr = mediatr;
    }

    @Endpoint(path = "/getAll", method = HttpMethod.GET)
    public HandleResult getAll() {
        return ok(mediatr.send(new GetAllAnimalAdvertsQuery()));
    }

    @Endpoint(path = "/getById", method = HttpMethod.GET)
    public HandleResult getById(@FromQuery(parameterName = "id") int id) {
        return ok(mediatr.send(new GetAnimalAdvertQuery(id)));
    }

    @RequireAuthentication
    @Endpoint(path = "/delete", method = HttpMethod.DELETE)
    public HandleResult delete(@FromQuery(parameterName = "id") int id, @WebToken(parameterName = "id") int userId,
                               @WebToken(parameterName = "role") String role) {
        if (!AuthUtils.allowRoles(role, User.Role.ADMINISTRATOR, User.Role.MODERATOR)) {
            var animalAdvertDao1 = serviceProvider.getRequiredService(AnimalAdvertDao.class);
            var advert = animalAdvertDao1.getEntityById(id);
            if (advert.getOwner().getId() != userId) {
                return notAuthorized();
            }
        }
        var animalAdvertDao = serviceProvider.getRequiredService(AnimalAdvertDao.class);
        animalAdvertDao.delete(id);
        return ok();
    }

    @RequireAuthentication
    @Endpoint(path = "/create", method = HttpMethod.POST)
    public HandleResult create(@FromBody CreateAnimalAdvertCommand command) {
        if (Validation.isAnyNullOrEmpty(command.animalType, command.description, command.sex, command.title)
                || command.birthdate == null
                || !Validation.in(command.sex, "M", "F")
                || !Validation.in(command.animalType, "Кот", "Собака", "Другое")) {
            return badRequest();
        }
        return ok(mediatr.send(command));
    }

    @Endpoint(path = "/getByUserId", method = HttpMethod.GET)
    public HandleResult getByUserId(@FromQuery(parameterName = "id") int userId) {
        return ok(mediatr.send(new GetAnimalAdvertsByUserIdQuery(userId)));
    }

    @Endpoint(path = "/getByShelterId", method = HttpMethod.GET)
    public HandleResult getByShelterId(@FromQuery(parameterName = "id") int id) {
        return ok(mediatr.send(new GetAnimalAdvertsByShelterIdQuery(id)));
    }

    @RequireAuthentication
    @Endpoint(path = "/getMine", method = HttpMethod.GET)
    public HandleResult getMy(@WebToken(parameterName = "id") int id) {
        return getByUserId(id);
    }
}
