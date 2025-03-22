import { fetchUtils } from "react-admin";

const apiUrl = "http://localhost:8080/api";

const httpClient = async (url: string, options: any = {}) => {
  const token = localStorage.getItem("real-estate-auth-token");
  if (!options.headers) {
    options.headers = new Headers({ Accept: "application/json" });
  }
  options.headers.set("Authorization", `Bearer ${token}`);
  return fetchUtils.fetchJson(url, options);
};

export { apiUrl, httpClient };
