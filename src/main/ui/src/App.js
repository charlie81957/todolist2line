import logo from './logo.svg';
import './App.css';
import { Route, Switch, Redirect } from 'react-router';
import React from 'react';
import LoginForm from './components/LoginForm';
import TodoList from './components/TodoList';
import RegistTodo from './components/RegistTodo';
import {useDispatch, useSelector} from 'react-redux';
import { getLoginedUser, getTodoList } from './Selectors';
import { render } from 'react-dom';
import { push } from 'connected-react-router';

// function requireAuth() {
//   const userSelector = useSelector(state => state.users)
//   const loginedUser = getLoginedUser(userSelector)
// }
// class App extends React.Component {
//   render() {
//     // const UseSelector = useSelector(state => state.users)
//     return (
//       <div className="App">
//         <Switch>
//           <Route exact path="/todo/regist" component={RegistTodo}/>
//           <Route exact path="/login" component={LoginForm}/>
//           <Route exact path="/" component={TodoList} />
//         </Switch>
//       </div>
//     )
//   }
// }
const App = () => {
  const requireAuth = () => {
    console.log(loginedUser.length)
    if (loginedUser.length < 1) {
      // push('/login')
      return false
    }
    return true
  }
  
  const userSelector = useSelector(state => state.users)
  const loginedUser = getLoginedUser(userSelector)

    return (
      <div className="App">
        <Switch>
        {/* <Route exact path="/todo/regist" render={() => (
          requireAuth() ? (
            // <Redirect to="/todo/regist"/>
            <RegistTodo />
          ) : (
            <LoginForm />
          )
        )}/> */}
          <Route exact path="/todo/regist" component={RegistTodo} onEnter={requireAuth}/>
          <Route exact path="/login" component={LoginForm}/>
          {/* <Route exact path="/" render={() => (
          requireAuth() ? (
            // <Redirect to="/"/>
            <TodoList />
          ) : (
            <LoginForm />
          )
        )}/> */}
          <Route exact path="/" component={TodoList} onEnter={requireAuth}/>
        </Switch>
      </div>
    )
}

export default App;
