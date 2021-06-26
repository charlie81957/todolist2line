import { createSelector } from "reselect";

const todoListsSelector = (state) => state.todoList;

export const getTodoList = createSelector(
    [todoListsSelector],
    state => state
);

const userSelector = (state) => state.uid
export const getLoginedUser = createSelector(
    userSelector,
    state => state
)