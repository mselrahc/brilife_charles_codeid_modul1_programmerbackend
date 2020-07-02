import { GET_USAGE_REPORT } from "../actions/constants";

const defaultState = {
  data: [],
  isLoading: false,
  error: null,
};

export default function usages(state = defaultState, { type, data, error }) {
  switch (type) {
    case GET_USAGE_REPORT.REQUEST:
      return { ...state, isLoading: true, error: null };
    case GET_USAGE_REPORT.SUCCESS:
      return { ...state, isLoading: false, data: data.data, error: null };
    case GET_USAGE_REPORT.FAILURE:
      return { ...state, isLoading: false, error };
    default:
      return state;
  }
}
