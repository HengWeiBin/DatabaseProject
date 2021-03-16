import registerReducer from './registerRedux';
import loginReducer from './loginRedux';
import { combineReducers } from 'redux';
import productReducer from './productReducer';
import UserOrderListReducer from './UserOrderListReducer';
import UserMyLikeReducer from './UserMyLikeReducer';
import SellerUserReducer from './SellerUserReducer';
import SellerOrderReducer from './SellerOrderReducer';
import SellerProductReducer from './SellerProductReducer';
import UserDiscountListReducer from './UserDiscountListReducer';
import SellerDiscountListReducer from './SellerDiscountList'

const rootReducer = combineReducers({
    LoginUser: loginReducer,
    registerUser: registerReducer,
    ProductList: productReducer,
    userOrderList: UserOrderListReducer,
    userMyLike: UserMyLikeReducer,
    sellerUser: SellerUserReducer,
    sellerOrder: SellerOrderReducer,
    sellerProduct: SellerProductReducer,
    userDiscountList: UserDiscountListReducer,
    sellerDiscountList:SellerDiscountListReducer
})

export default rootReducer