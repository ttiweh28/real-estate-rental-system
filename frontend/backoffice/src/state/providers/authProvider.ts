import { AuthProvider } from "react-admin";

const authProvider: AuthProvider = {
  login: ({ username, password }) => {
    return fetch("http://localhost:8080/api/auth/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ username, password }),
    }).then((response) => {
      if (response.ok) {
        return response.json().then((data) => {
            localStorage.setItem("real-estate-auth-token", data.jwt);
            localStorage.setItem("real-estate-auth-user", JSON.stringify(data.user));
            return Promise.resolve();
        });
      } else {
        return Promise.reject(new Error("Invalid credentials"));
      }
    });
  },
  logout: () => {
    localStorage.removeItem("real-estate-auth-token");
    localStorage.removeItem("real-estate-auth-user");
    return Promise.resolve();
  },
  checkAuth: () => {
    // TODO: Check if token is valid here
    return localStorage.getItem("real-estate-auth-token") ? Promise.resolve() : Promise.reject();
  },
  checkError: (error) => {
    if (error.status === 401 || error.status === 403) {
      localStorage.removeItem('auth');
      return Promise.reject();
    }
    return Promise.resolve();
  },
  getPermissions: () => {
    const auth = localStorage.getItem("real-estate-auth-token");
    const authUser = localStorage.getItem("real-estate-auth-user")
    if (!auth || !authUser) {
      return Promise.reject(new Error("Invalid credentials"));
    }
    return Promise.resolve(JSON.parse(authUser)?.role)
  },
  getIdentity: () => {
    const currentUser = JSON.parse(localStorage.getItem('real-estate-auth-user') || '{}');
    const adminUser = {...currentUser, fullName: `${currentUser.firstName} ${currentUser.lastName}`}
    if (!currentUser || !adminUser) {
      return Promise.reject(new Error("Invalid credentials"));
    }
    return adminUser
  },
};

export default authProvider;
