const SellerProductReducer = (state = [], action) => {
    switch(action.type){
        case "SET_SELLER_PRODUCT":{
            return [...action.sellerProduct]
        }
        default:
            return state;
    }
}

export default SellerProductReducer;
