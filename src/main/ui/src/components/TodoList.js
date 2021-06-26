import React, {useState, useEffect} from 'react';
import { connect } from 'react-redux';
import { fetchTodoList, deleteTodo, editTodo } from '../operation';
import Header from './Header';
import {useDispatch, useSelector} from 'react-redux';
import {Link} from 'react-router-dom';
import { getLoginedUser, getTodoList } from '../Selectors';
import Modal from 'react-modal';
import {push} from 'connected-react-router';

const TodoList = () => {
    const dispatch = useDispatch();
    const todoSelector = useSelector(state => state.todoList)
    const todoList = getTodoList(todoSelector)
    const userSelector = useSelector(state => state.users)
    const loginedUser = getLoginedUser(userSelector)
    
    useEffect(() => {
        // dispatch(fetchTodoList(loginedUser));
        dispatch(fetchTodoList("test"));
    },[])

    const onCheckClick = () => {
        dispatch(deleteTodo(todoId))
    }
    const openDeletedModal = (e) => {
        setTodoId(e.target.id)
        setShowModal(true)
    }
    const editTodoClick = (e) => {
        const selectedTodo = todoList.find(sp => sp.todoId == e.target.id)
        // 登録コンポーネントに選択されたTodoIdを持って更新する
        dispatch(push({
            pathname: '/todo/regist',
            state: selectedTodo
        }))
    }
    // Modal flag
    const [showModal, setShowModal] = useState(false);
    const [todoId, setTodoId] = useState("")

    // modal style
    const modalStyle = {
        overlar: {
            position: "fixed",
            top: 0,
            left: 0
        },
        content: {
            position: "absolute",
            width: "200px",
            height: "200px",
            marginLeft: "auto",
            marginRight: "auto",
            marginTop: "2rem"
        }
    }

    if (todoList != null) {
        return (
        <div className="container">
            <Header />
            {/* Not Completed Yet */}
            <table className="table table-striped">
                <thead className="thead-dark">
                <tr>
                <th scope="col" style={{width: '10%'}}></th>
                <th scope="col" className="text-left" style={{width: '80%'}}>タイトル</th>
                <th scope="col" style={{width: '10%'}}></th>
                </tr>
            </thead>
            <tbody>
                            
            {todoList && todoList.filter(fil => fil.done == false)
                .map(post => 
                  <tr key={post.todoId}>
                    <th ><a className="card-link" id={post.todoId} onClick={openDeletedModal}><i className="fas fa-check" id={post.todoId}></i></a></th>
                    <td className="text-left"><Link to={`/blog-posts/${post.todoId}`}>{post.todoTitle}</Link></td>
                    <td><a className="card-link"><i className="fas fa-edit" onClick={editTodoClick} id={post.todoId}></i></a></td>
                  </tr>                 
            )}
            </tbody>
            </table>
            <div style={{textAlign: 'left'}}>
                <h4>完了した項目</h4>
            </div>
            {/* Already Completed */}
            <table className="table table-striped ">
                <thead>
                <tr>
                <th scope="col" style={{width: '10%'}}></th>
                <th scope="col" className="text-left" style={{width: '80%'}}>タイトル</th>
                <th scope="col" style={{width: '10%'}}></th>
                </tr>
            </thead>
            <tbody>
                            
            {todoList && todoList.filter(fil => fil.done == false)
                .map(post => 
                    <tr key={post.todoId}>
                    <th ><a className="card-link" id={post.todoId} onClick={openDeletedModal}><i className="fas fa-times" id={post.todoId}></i></a></th>
                    <td className="text-left"><Link to={`/blog-posts/${post.todoId}`}>{post.todoTitle}</Link></td>
                    <td><a className="card-link"><i className="fas fa-edit"></i></a></td>
                  </tr>                 
            )}
            </tbody>
            </table>
            <div style={{height: '3em', textAlign: 'right'}} className="p-2">
                <Link to={'/todo/regist'}><i className="fas fa-plus-circle fa-3x"></i></Link>
            </div>
            {/* Push SignUp Method  */}
            <Modal isOpen={showModal}
                ariaHideApp={false}
                style={modalStyle}
                >
                    <h5>削除</h5>
                    <p>完了した項目を削除します。<br/>よろしいですか</p>
                    
                <button style={{display: 'inline-block'}} className="btn btn-primary" onClick={onCheckClick}>削除</button>
                <button style={{display: 'inline-block'}} className="btn btn-danger" onClick={() => setShowModal(false)}>キャンセル</button>
            </Modal>
        </div>
        )
    }
    else {
        return (
        <div className="container">     
            <Header />
        </div>
        )
    }
}
export default TodoList;