import { GET_PROVINCES } from "../actions/constants";

const defaultState = {
  data: [],
  isLoading: false,
  error: null,
};

export default function provinces(state = defaultState, { type, data, error }) {
  switch (type) {
    case GET_PROVINCES.REQUEST:
      return { ...state, isLoading: true, error: null };
    case GET_PROVINCES.SUCCESS:
      return { ...state, isLoading: false, data: data.data.list, error: null };
    case GET_PROVINCES.FAILURE:
      return { ...state, isLoading: false, error };
    default:
      return state;
  }
}
