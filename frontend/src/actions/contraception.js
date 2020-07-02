import { GET_CONTRACEPTIONS } from "./constants";
import { commonFetch } from "../utils/apiUtils";

export const getContraceptions = () => (dispatch) => {
  dispatch({
    type: GET_CONTRACEPTIONS.REQUEST,
  });

  commonFetch("contraceptions").then(
    (resp) => {
      dispatch({
        type: GET_CONTRACEPTIONS.SUCCESS,
        data: resp,
      });
    },
    (err) => {
      dispatch({
        type: GET_CONTRACEPTIONS.FAILURE,
        error: err,
      });
    }
  );
};
