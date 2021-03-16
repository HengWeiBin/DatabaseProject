const UserDiscountListReducer = (state = [], action) => {
    switch(action.type){
        case "SET_DISCOUNT_LIST":{
            return [...action.userDiscountList]
        }
        default:
            return state;
    }
}

export default UserDiscountListReducer;
