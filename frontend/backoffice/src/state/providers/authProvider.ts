import { I_User } from "@/types/authTypes";
import { AuthProvider } from "react-admin";

const users: Record<string, I_User> = {
  justine: {
    id: "user123",
    firstName: "Justine",
    lastName: "Okumu",
    fullName: "Okumu Justine",
    username: "okumu",
    role: "propertyOwner",
    password: "1234",
    avatar: "https://example.com/avatar.jpg",
  },
  tiffany: {
    id: "user456",
    firstName: "Tiffany",
    lastName: "Lamaro",
    fullName: "Lamaro Tiffany",
    username: "tiffany",
    role: "admin",
    password: "1234",
    avatar: "https://example.com/avatar.jpg",
  },
};

const authProvider: AuthProvider = {
  login: ({ username, password }: { username: string; password: string }) => {
    if (users[username] && users[username].password === password) {
      localStorage.setItem("auth", "true");
      localStorage.setItem("username", username);
      return Promise.resolve();
    }
    return Promise.reject(new Error("Invalid credentials"));
  },
  logout: () => {
    localStorage.removeItem("auth");
    localStorage.removeItem("username");
    return Promise.resolve();
  },
  checkAuth: () => {
    return localStorage.getItem("auth") ? Promise.resolve() : Promise.reject();
  },
  checkError: () => {
    return Promise.resolve();
  },
  getPermissions: () => {
    const username = localStorage.getItem("username");
    return username && users[username]
      ? Promise.resolve(users[username].role)
      : Promise.reject();
  },
  getIdentity: () => {
    const username = localStorage.getItem("username");
    if (username && users[username]) {
      return Promise.resolve(users[username]);
    }
    return Promise.reject(new Error("User not found"));
  },
};

export default authProvider;
