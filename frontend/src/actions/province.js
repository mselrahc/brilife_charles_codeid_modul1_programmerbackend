import { GET_PROVINCES } from "./constants";
import { commonFetch } from "../utils/apiUtils";

export const getProvinces = () => (dispatch) => {
  dispatch({
    type: GET_PROVINCES.REQUEST,
  });

  commonFetch("provinces").then(
    (resp) => {
      dispatch({
        type: GET_PROVINCES.SUCCESS,
        data: resp,
      });
    },
    (err) => {
      dispatch({
        type: GET_PROVINCES.FAILURE,
        error: err,
      });
    }
  );
};
