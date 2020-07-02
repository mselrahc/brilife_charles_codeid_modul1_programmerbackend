import { ADD_USAGE } from "../actions/constants";

const defaultState = {
  data: {},
  isLoading: false,
  message: null,
};

export default function usage(state = defaultState, { type, data, error }) {
  switch (type) {
    case ADD_USAGE.REQUEST:
      return { ...state, isLoading: true, error: null };
    case ADD_USAGE.SUCCESS:
      return {
        ...state,
        isLoading: false,
        data,
        message: { message: "Berhasil" },
      };
    case ADD_USAGE.FAILURE:
      return { ...state, isLoading: false, message: error };
    default:
      return state;
  }
}
