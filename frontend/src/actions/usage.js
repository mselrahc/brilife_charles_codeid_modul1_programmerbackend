import { ADD_USAGE, GET_USAGE_REPORT } from "./constants";
import { commonFetch } from "../utils/apiUtils";

export const addUsage = ({ provinceId, contraceptionId, usageCount }) => (
  dispatch
) => {
  dispatch({
    type: ADD_USAGE.REQUEST,
  });
  commonFetch("usages", {
    method: "POST",
    body: JSON.stringify({
      province: { id: provinceId },
      contraception: { id: contraceptionId },
      count: usageCount,
    }),
    headers: {
      "Content-Type": "application/json",
    },
  }).then(
    (resp) => {
      dispatch({
        type: ADD_USAGE.SUCCESS,
        data: resp,
      });
      console.log(resp);
    },
    (err) => {
      dispatch({
        type: ADD_USAGE.FAILURE,
        error: err,
      });
      console.log(err);
    }
  );
};

export const getUsageReport = () => (dispatch) => {
  dispatch({
    type: GET_USAGE_REPORT.REQUEST,
  });

  commonFetch("usages/report").then(
    (resp) => {
      dispatch({
        type: GET_USAGE_REPORT.SUCCESS,
        data: resp,
      });
    },
    (err) => {
      dispatch({
        type: GET_USAGE_REPORT.FAILURE,
        error: err,
      });
    }
  );
};
