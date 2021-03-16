const SellerOrderReducer = (state = [], action) => {
    switch(action.type){
        case "SET_SELLER_ORDER":{
            return [...action.sellerOrder]
        }
        default:
            return state;
    }
}

export default SellerOrderReducer;
