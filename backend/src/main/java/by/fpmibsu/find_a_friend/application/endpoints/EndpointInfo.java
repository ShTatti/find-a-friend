package by.fpmibsu.find_a_friend.application.endpoints;

import by.fpmibsu.find_a_friend.application.HttpMethod;
import by.fpmibsu.find_a_friend.application.mediatr.Request;
import by.fpmibsu.find_a_friend.application.mediatr.RequestHandler;

public record EndpointInfo<T, R extends Request<? super T>>(String path, Class<R> requestType, Class<T> responseType,
                                                            Class<? extends RequestHandler<T, R>> handlerType,
                                                            HttpMethod method) {
}
