import { combineReducers } from "redux";
import provinces from "./provinces";
import contraceptions from "./contraceptions";
import usage from "./usage";
import usages from "./usages";

export default combineReducers({
  provinces,
  contraceptions,
  usage,
  usages,
});
