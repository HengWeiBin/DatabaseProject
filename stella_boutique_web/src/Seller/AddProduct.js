import React, { useState } from "react";
import ReactDOM from 'react-dom';
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import "../Login.css";
import { makeStyles } from '@material-ui/core/styles';
import { connect } from 'react-redux';
import { addProduct} from '../actions';

const useStyles = makeStyles((theme) => ({
    navButtons: {
      fontFamily: 'Bebas Neue',
      '&:hover': {
        color:'#c26d5c'
     },
    }
  })); 



function AddProduct(props) {
  var imgUrl = "./img/";
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [description, setDescription] = useState("");
  const [size, setSize] = useState("");
  const [category, setCategory] = useState("");
  const [quantity, setQuantity] = useState("");

  var fileInput = React.createRef();


  var input = document.getElementsByTagName("input")[0];
  var binaryData = [];
  binaryData.push(input);
  
 
  function handleSubmit(event) {
    var src = `${fileInput.current.files[0].name}`;
    console.log(src);
    imgUrl = imgUrl+src;
    console.log(imgUrl);
    props.addProduct(name,quantity,category,size,price,description,imgUrl);
    event.preventDefault();
    window.location.href = '/ProductManage';

  }

  let button = null;

  return (
    <div className="Login">
      <Form name="form">
        <h2>ADD PRODUCT</h2>
        <Form.Group size="lg" controlId="picform">
        <Form.Label>Product Picture</Form.Label>
            <input
                accept="image/*"
                style={{ margin:"10px 0" }}
                id="raised-button-file"
                multiple
                type="file"
                ref={fileInput}
                className="pic"
            />
        </Form.Group>

        <Form.Group size="lg" controlId="name">
          <Form.Label>Product Name</Form.Label>
          <Form.Control
            autoFocus
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          </Form.Group>

        <Form.Group size="lg" controlId="category">
          <Form.Label>Category</Form.Label>
          <Form.Control
            autoFocus
            type="text"
            value={category}
            onChange={(e) => setCategory(e.target.value)}
          />
          </Form.Group>

        <Form.Group size="lg" controlId="size">
          <Form.Label>Size</Form.Label>
          <Form.Control
            autoFocus
            type="text"
            value={size}
            onChange={(e) => setSize(e.target.value)}
          />
          </Form.Group>


        <Form.Group size="lg" controlId="price">
          <Form.Label>Price</Form.Label>
          <Form.Control
            type="text"
            value={price}
            onChange={(e) => setPrice(e.target.value)}
          />
        </Form.Group>

        <Form.Group size="lg" controlId="description">
          <Form.Label>Description</Form.Label>
          <Form.Control
            type="textarea"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
          />
        </Form.Group>

        <Form.Group size="lg" controlId="quantity">
          <Form.Label>Quantity</Form.Label>
          <Form.Control
            type="text"
            value={quantity}
            onChange={(e) => setQuantity(e.target.value)}
          />
        </Form.Group>

        <Button className="LoginBtn" block size="lg" variant="outline-secondary" onClick={handleSubmit} value="Submit">
          ADD
        </Button>
      </Form>

    </div>
  );
}

function mapDispatchToProps(dispatch) {
  return {
    addProduct: (name,quantity,category,size,price,description,pictureURL) => {
      dispatch(addProduct(name,quantity,category,size,price,description,pictureURL))
    }
  }
}

export default connect(null,mapDispatchToProps)(AddProduct);
