import { createStore as reduxCreateStore, combineReducers, applyMiddleware } from 'redux';
import { connectRouter, routerMiddleware } from 'connected-react-router';
import thunk from 'redux-thunk';
import UserReducer from './reduces/login';

export default function createStore(history) {
    return reduxCreateStore(
        combineReducers({
            router: connectRouter(history),
            users: UserReducer,
        }),
        applyMiddleware(
            routerMiddleware(history),
            thunk
        )
    )
}