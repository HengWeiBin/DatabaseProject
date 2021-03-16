const SellerUserReducer = (state = [], action) => {
    switch(action.type){
        case "SET_SELLER_USER":{
            return [...action.sellerUser]
        }
        default:
            return state;
    }
}

export default SellerUserReducer;
