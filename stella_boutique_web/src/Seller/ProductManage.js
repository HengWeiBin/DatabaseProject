import React, { Component } from 'react';
import '../App.css';
import 'bootstrap/dist/css/bootstrap.css';
import { connect } from 'react-redux';
import { withRouter } from "react-router-dom";
import { Container, Row, Col, Jumbotron, Card, CardImg, CardBody ,  CardTitle, CardSubtitle, CardText, Badge } from 'reactstrap';
import { Form,FormControl,Button } from 'react-bootstrap';
import ProductItemForSeller from '../ProductItemForSeller';


class ProductManage extends Component {
  constructor(props){
    super(props)
  }
  
    render() {
        return (
            <div>              
                <div style={{margin:'10px' , display: 'flex',  justifyContent:'flex-end ', alignItems:'center'}}>
                    <Form inline>
                        <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                        <Button variant="outline-dark">Search</Button>
                    </Form>
                </div>
                <Row style={{margin:'10px 100px' , display: 'flex',  justifyContent:'flex-end ', alignItems:'center'}}>
                {
                  this.props.sellerProduct.map((item,key) => {
                      return(
                       <ProductItemForSeller key={item.itemID} product={item}/>
                      )
                    
                  })
                }
                </Row>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
      sellerProduct: state.sellerProduct
    }
  }
  
  export default connect(mapStateToProps,null)(withRouter(ProductManage));