const SellerDiscountListReducer = (state = [], action) => {
    switch(action.type){
        case "SET_SELLER_DISCOUNT_LIST":{
            return [...action.sellerDiscountList]
        }
        default:
            return state;
    }
}

export default SellerDiscountListReducer;
