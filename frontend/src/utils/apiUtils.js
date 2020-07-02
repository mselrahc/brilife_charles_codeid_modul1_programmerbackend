const url = "http://localhost:8080/";

export async function commonFetch(path, init) {
  const resp = await fetch(url + path, init);
  let ok, data;
  if (!resp.ok) {
    ok = false;
    data = {
      code: resp.status,
      message: resp.statusText,
      data: null,
    };
  } else {
    data = await resp.json();
    ok = !data.code;
  }
  return new Promise((resolve, reject) => {
    if (ok) {
      resolve(data);
    } else {
      reject(data);
    }
  });
}
