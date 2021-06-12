import React from 'react';
import { connect } from 'react-redux';

// class TodoList extends React.Component {
//     render() {
//         return (
//         <div className="container">
//             List!
//         </div>)
//     }
// }

// export default TodoList;

const TodoList = () => {
    return (
    <div className="container">
        List!
        {/* {posts && posts.map(post => (
                <div className="card mb-3 mt-3 shadow-sm" key={post.id}>
                    <div className="card-body">
                        <h3>
                            <Link to={`/blog-posts/${post.id}`}>{post.title}</Link>
                        </h3>
                        <p className="card-text border-top">
                            <small className="text-muted">
                                {timeago().format(post.published)}
                            </small>
                        </p>
                    </div>
                </div>
            ))} */}
    </div>
    )
}
export default TodoList;