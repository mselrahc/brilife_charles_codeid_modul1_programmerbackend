function createAsyncType(name) {
  return {
    REQUEST: name + "_REQUEST",
    SUCCESS: name + "_SUCCESS",
    FAILURE: name + "_FAILURE",
  };
}

export const ADD_USAGE = createAsyncType("ADD_USAGE");
export const GET_USAGE_REPORT = createAsyncType("GET_USAGE_REPORT");

export const GET_PROVINCES = createAsyncType("GET_PROVINCES");
export const GET_CONTRACEPTIONS = createAsyncType("GET_CONTRACEPTIONS");
