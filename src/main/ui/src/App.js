import './App.css';
import { Route, Switch, Redirect } from 'react-router';
import React, { useEffect, useState } from 'react';
import LoginForm from './components/LoginForm';
import TodoList from './components/TodoList';
import RegistTodo from './components/RegistTodo';

const checkAuth = () => {
  const tokenString = sessionStorage.getItem('token')
  const userToken = JSON.parse(tokenString)
  if (!userToken) {
    return false
  }
  else {
    return true
  }
}
const App = () => {
  return (
    <div className="App">
      <Switch>
        <Route exact path="/todo/regist" render={() => (
          checkAuth() ? (
            // <Redirect exact to="/todo/regist"/>
            <Route exact path="/todo/regist" component={RegistTodo} />
          ) : (
            <LoginForm />
          )
        )}/>
        <Route exact path="/login" component={LoginForm}/>
        <Route exact path="/" render={() => (
          checkAuth() ? (
            // <Redirect exact to="/todo/regist"/>
            <Route exact path="/" component={TodoList} />
          ) : (
            <LoginForm />
          )
        )}/>
      </Switch>
    </div>
  )
}

export default App;
