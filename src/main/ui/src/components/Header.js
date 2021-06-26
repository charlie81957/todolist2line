import React from 'react';
import {Link} from 'react-router-dom'
const Header = () => {
    return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <Link to="/" className="navbar-brand">
            TODO List
        </Link>
        <span className="navbar-text">
            <Link to="/login">SignOut</Link>
        </span>
    </nav>
    )
}
export default Header;