import logo from './logo.svg';
import './App.css';
import { Route, Switch } from 'react-router';
import React from 'react';
import LoginForm from './components/LoginForm';
import TodoList from './components/TodoList';

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <Switch>
          <Route exact path="/login" component={LoginForm}/>
          <Route exact path="/" component={TodoList}/>
        </Switch>
      </div>
    )
  }
}

export default App;
