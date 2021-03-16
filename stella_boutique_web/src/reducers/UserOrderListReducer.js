const UserOrderListReducer = (state = [], action) => {
    switch(action.type){
        case "SET_ORDER_LIST":{
            return [...action.userOrderList]
        }
        default:
            return state;
    }
}

export default UserOrderListReducer;
