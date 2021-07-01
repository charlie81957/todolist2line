import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { createTodo, editTodo } from '../operation';
import { useState, useCallback} from 'react';
import {push} from 'connected-react-router';
import Header from './Header';

const RegistTodo = (props) => {
    const editingTodo = props.location.state
    // 初期値を入れる
    var d = new Date();
    var datetext = d.toTimeString()
    datetext = datetext.split(' ')[0];
    var dateString = d.getFullYear() +"-"+ (d.getMonth()+1) +"-"+ d.getDate() + "T" + datetext.split(':')[0] + ":" + datetext.split(':')[1];
    console.log(dateString)
    /**
     * click method
　　　*/
    const dispatch = useDispatch();

    const [title, setTitle] = useState(editingTodo ? editingTodo.todoTitle : "")
    const inputTitle = useCallback((e) => { 
        setTitle(e.target.value);
    },[]);
    const [detail, setDetail] = useState(editingTodo ? editingTodo.todoContent : "")
    const inputDetail = useCallback((e) => { 
      setDetail(e.target.value);
    },[]);
    
    const [limit, setLimit] = useState(editingTodo ? editingTodo.limitDateTime.substr(0, 16) : dateString)
    const inputLimit = useCallback((e) => { 
      setLimit(e.target.value);
    },[]);
    // const [notice, setNotice] = useState(editingTodo ? editingTodo.todoTitle : "")
    const [notice, setNotice] = useState("")
    const inputNotice = useCallback((e) => { 
        setNotice(e.target.value);
    },[]);
    

    // INSERT or UPDATE
    const checkFlag = () => {
      if (!editingTodo) {
        console.dir(infoTodoList)
        dispatch(createTodo(title, detail, limit, notice))
        console.dir(infoTodoList)
        if (infoTodoList.createFlag) {
          dispatch(push('/'))
        }
      }
      else {
        dispatch(editTodo(editingTodo.todoId, title, detail, limit, notice))
      }
    }

    const infoUser = useSelector(state => state.users)
    const infoTodoList = useSelector(state => state.todoList)

    return (
      <div className="col-12">
        <Header />
        <h4 className="mb-3">新規登録</h4>
        <form className="needs-validation" data-toggle="validator">
          <div className="row g-3">
              {/* タイトル */}
            <div className="col-12">
              <label htmlFor="firstName" className="form-label">タイトル</label>
              <input value={title} type="text" className="form-control" id="firstName" placeholder="" onChange={inputTitle} required />
              <div className="invalid-feedback">
                名字を入力してください。
              </div>
            </div>
            {/* 詳細 */}
            <div className="col-12">
              <label htmlFor="firstName" className="form-label">詳細</label>
              <textarea value={detail} className="form-control" id="exampleFormControlTextarea1" rows="3" onChange={inputDetail}></textarea>
              {/* <input type="textarea" className="form-control" id="firstName" placeholder="" value="" required /> */}
              <div className="invalid-feedback">
                名字を入力してください。
              </div>
            </div>
            {/* 期限 */}
            <div className="col-12">
            <label htmlFor="firstName" className="form-label">期限</label>
            <div className="input-group date mb-3" id="datetimepicker1" data-target-input="nearest">
                <input value={limit} type="datetime-local" className="form-control datetimepicker-input" data-target="#datetimepicker1" required onChange={inputLimit} />                
            </div>
        </div>
            {/* 通知 */}
            <div className="col-12">
            <label htmlFor="firstName" className="form-label d-block">通知</label>
            {/* <div className="row"> */}
                <input value={notice} type="number" step="5" className="form-control col-6 d-inline-block" id="firstName" placeholder="" required onChange={inputNotice} />
                <select className="form-control col-4 d-inline-block">
                <option>分前</option>
                {/* <option>時間前</option> */}
                </select>
            {/* </div> */}
        </div>
          </div>
          <button 
            className="w-100 btn btn-primary btn-lg mt-3" 
            type="submit"
            onClick={checkFlag}
          >追加</button>
        </form>
      </div>

    )
}
export default RegistTodo;