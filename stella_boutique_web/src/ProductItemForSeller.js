import React, { useState} from 'react';
import {Col, Card, CardImg, CardBody ,  CardTitle, CardSubtitle, CardText, Badge } from 'reactstrap';
import { Button } from 'react-bootstrap';
import { connect } from 'react-redux';
import TextField from '@material-ui/core/TextField';
import EdiText from 'react-editext'
import './ProductItem.css';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import {editProduct,removeProduct} from './actions';

function ProductItemForSeller(props){
    var cartItems = localStorage.getItem('cart') ? JSON.parse(localStorage.getItem('cart')) : [];
    const onSaveName = (val,payload) => {
        console.log('Edited name -> ', val)
        console.log('product name -> ',payload.name)
        // props.editProduct(payload.itemID,payload.name,payload.price,payload.description)
        props.editProduct(payload.itemID,val,payload.price,payload.description)
    }

    const onSavePrice = (val,payload) => {
        console.log(val)
        console.log(payload.price)
        props.editProduct(payload.itemID,payload.name,val,payload.description)
    }

    const onSaveDescription = (val,payload) =>  {
        console.log('Edited description -> ', val)
        props.editProduct(payload.itemID,payload.name,payload.price,val)
    }

    const [open, setOpen] = React.useState(false);
    const handleClickOpen = () => {
        setOpen(true);
      };
    
      const handleClose = () => {
        setOpen(false);
      };

    const [userID,setUserID] = useState(localStorage.getItem("userID"));
    
    const deleteProduct = payload => {
        console.log('delete  -> ', payload.itemID)
        props.removeProduct(payload.itemID);
        window.location.reload();
    }
    
    return ( 
        <Col sm={6} md={4} className="mb-3" >
            <Card style={{margin:'0px 50px'}}>
                <div className="img">
                    <CardImg className="card-img" src={require(""+props.product.pictureURL)} alt="Card image cap" />
                </div>
                {props.product.quantity==0?
                    <div>
                        <p>賣完</p>
                    </div>
                    :
                    null
                }
                <CardBody >
                    <EdiText
                    type='text'
                    value={props.product.name}
                    onSave={(value) => onSaveName(value, props.product)}
                    buttonsAlign='before'
                    saveButtonContent="V"
                    cancelButtonContent="X"
                    saveButtonClassName="save-button"
                    editButtonClassName="edit-botton"
                    cancelButtonClassName="cancel-botton"
                    editButtonContent="Edit"
                    />  

                     售價:
                        <EdiText
                        type='text'
                        value={props.product.price}
                        onSave={(value) => onSavePrice(value, props.product)}
                        buttonsAlign='before'
                        saveButtonContent="V"
                        cancelButtonContent="X"
                        saveButtonClassName="save-button"
                        editButtonClassName="edit-botton"
                        cancelButtonClassName="cancel-botton"
                        editButtonContent="Edit"
                        />
                    
                        <EdiText
                        type='text'
                        value={props.product.description}
                        onSave={(value) => onSaveDescription(value, props.product)}
                        type="textarea"
                        buttonsAlign='before'
                        saveButtonContent="V"
                        cancelButtonContent="X"
                        saveButtonClassName="save-button"
                        editButtonClassName="edit-botton"
                        cancelButtonClassName="cancel-botton"
                        editButtonContent="Edit"
                    />
                <Button color="secondary" onClick={handleClickOpen}>刪除</Button>
                <Dialog
                    open={open}
                    onClose={handleClose}
                    aria-labelledby="alert-dialog-title"
                    aria-describedby="alert-dialog-description"
                >
                    <DialogTitle id="alert-dialog-title">{"Delete Product"}</DialogTitle>
                    <DialogContent>
                        <DialogContentText id="alert-dialog-description">
                            Do you want to delete this product?
                        </DialogContentText>
                    </DialogContent>
                    <DialogActions>
                    <Button style={{backgroundColor:"red"}} onClick={handleClose} color="primary">
                        No
                    </Button>
                    <Button color="secondary" onClick={()=>{handleClose();deleteProduct(props.product);}} color="primary" autoFocus>
                        Yes
                    </Button>
                    </DialogActions>
                </Dialog>
                {/* <Button color="secondary" style={{margin:"10px"}} onClick={() => {setState({ editing: !state.editing });editProduct(props.product);}}>編輯</Button> */}
                </CardBody >
            </Card>
         </Col>
     );
}
function mapDispatchToProps(dispatch) {
    return {
    removeProduct: (itemID) => {
        dispatch(removeProduct(itemID))
      },
    editProduct: (itemID,name,price,description) => {
        dispatch(editProduct(itemID,name,price,description))
      } 
    }
  }
  export default connect(null,mapDispatchToProps)(ProductItemForSeller);