import { GET_CONTRACEPTIONS } from "../actions/constants";

const defaultState = {
  data: [],
  isLoading: false,
  error: null,
};

export default function contraceptions(
  state = defaultState,
  { type, data, error }
) {
  switch (type) {
    case GET_CONTRACEPTIONS.REQUEST:
      return { ...state, isLoading: true, error: null };
    case GET_CONTRACEPTIONS.SUCCESS:
      return { ...state, isLoading: false, data: data.data.list, error: null };
    case GET_CONTRACEPTIONS.FAILURE:
      return { ...state, isLoading: false, error };
    default:
      return state;
  }
}
