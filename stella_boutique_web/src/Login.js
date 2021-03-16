import React, { useState } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import "./Login.css";
import { makeStyles } from '@material-ui/core/styles';
import { useDispatch } from 'react-redux';
import { useHistory } from "react-router-dom";
import { Navbar } from 'react-bootstrap';
import { connect } from 'react-redux';
import { loginUser , getOrderList , getLikeItemList} from './actions';

const useStyles = makeStyles((theme) => ({
    navButtons: {
      fontFamily: 'Bebas Neue',
      '&:hover': {
        color:'#c26d5c'
     },
    }
  }));


function Login(props) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [userID, setUserID] = useState(0)

  function validateForm() {
    return username.length > 0 && password.length > 0;
  }
  
  function handleSubmit(event) {
    if(username == "admin" && password == "admin"){
      localStorage.setItem("userID",username);
      window.location.href = '/ProductManage';
    }else{
      props.loginUser(username,password,userID);
      event.preventDefault();
    }
  }

  function mount(){
    // if the server give the response data it will redirect to home page
    if(props.LoginUser.userID != null && props.LoginUser.userID !=0 ) {
      window.location.href = '/';
    }
  }

  function admin() {
    return username == "admin" && password == "admin";
  }

  let button = null;
  
  if (admin()) {
    button = <Button href="/ProductManage" className="LoginBtn" block size="lg" variant="outline-secondary" disabled={!validateForm()}>
    Login
  </Button>
  } else {
    button = <Button href="/" className="LoginBtn" block size="lg" variant="outline-secondary" disabled={!validateForm()}>
    Login
  </Button>
  }

  return (
    <div className="Login">
      <Form onSubmit={handleSubmit}>
        <Form.Group size="lg" controlId="email">
          <Form.Label>Username</Form.Label>
          <Form.Control
            autoFocus
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
        </Form.Group>
        <Form.Group size="lg" controlId="password">
          <Form.Label>Password</Form.Label>
          <Form.Control
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </Form.Group>
        <Button className="LoginBtn" block size="lg" variant="outline-secondary" type="submit" value="Submit">
          Login
        </Button>
      </Form>
      {mount()}
    </div>
  );
}

function mapStateToProps(state) {
  return {
    LoginUser: state.LoginUser
  }
}

function mapDispatchToProps(dispatch) {
  return {
    loginUser: (username,password,userID) => {
      dispatch(loginUser(username,password,userID))
    }
  }
}

export default connect(mapStateToProps,mapDispatchToProps)(Login);
