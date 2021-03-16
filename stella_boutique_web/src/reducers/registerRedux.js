const initialState = {
    username: "",
    password: "",
    fullname: "",
    birthday: "",
    address: "",
    phoneNumber: "",
    email: ""

}

const registerReducer = (state = initialState, action) => {
    switch(action.type) {
        case "REGISTER_USER": {
            return {
                ...state,
                username: action.username,
                password: action.password,
                fullname: action.fullname,
                birthday: action.birthday,
                address: action.address,
                phoneNumber: action.phoneNumber,
                email: action.email
            }
        }
        default:
            return state;
    }
}
export default registerReducer;