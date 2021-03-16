const UserMyLikeReducer = (state = [], action) => {
    switch(action.type){
        case "SET_MY_LIKE_LIST":{
            return [...action.userMyLike]
        }
        default:
            return state;
    }
}

export default UserMyLikeReducer;
