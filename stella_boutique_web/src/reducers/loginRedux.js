var initialState = {
    username: "",
    password: "",
    userID: 0
}

const loginReducer = (state = initialState, action) => {
    switch(action.type) {
        case "LOGIN_USER": {
            return {
                ...state,
                username: action.username,
                password: action.password,
                userID: action.userID
            }
        }
        case "SET_USER": {
            return {
                username: action.username,
                userID: action.userID
            }
        }
        default:
            return state;
    }
}
export default loginReducer;