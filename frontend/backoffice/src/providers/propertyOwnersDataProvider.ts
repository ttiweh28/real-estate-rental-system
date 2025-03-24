import { apiUrl, httpClient } from "@/httpClient";
import { E_UserRole, I_User } from "@/types/authTypes";
import { useNotify, useRedirect } from "react-admin";

export const propertyOwnersDataProvider = {
  getList: async (resource: string, params: any) => {
    const { json } = await httpClient(`${apiUrl}/users`);
    const users = json.user || [];

    return {
      data: users.map((user: any): I_User => ({
        id: user.userId,
        firstName: user.firstName,
        lastName: user.lastName,
        fullName: `${user.firstName} ${user.lastName}`,
        userName: user.userName,
        email: user.email,
        phoneNumber: user.phoneNumber,
        photo: user.photo,
        role: user.role as E_UserRole,
        address: {
          street: user.address.street,
          city: user.address.city,
          state: user.address.state,
          zipCode: user.address.zipCode,
          country: user.address.country,
        },
      })),
      total: users.length,
    };
  },
  create: async (resource: string, params: any) => {

    const { firstName, lastName, userName, email, phoneNumber, role, address, photo, password } = params.data;

    const formData = new FormData();
    formData.append("firstName", firstName);
    formData.append("lastName", lastName);
    formData.append("userName", userName);
    formData.append("email", email);
    formData.append("phoneNumber", phoneNumber);
    formData.append("password", password);
    formData.append("role", role);
    formData.append("address.street", address.street);
    formData.append("address.city", address.city);
    formData.append("address.state", address.state);
    formData.append("address.zipCode", address.zipCode);
    formData.append("address.country", address.country);

    if (photo && photo.rawFile) {
      formData.append("userPhoto", photo.rawFile);
    }

    await httpClient(`${apiUrl}/users`, {
      method: "POST",
      body: formData,
    });

    window.location.assign('/#/property-owners');

    return {}
    
  },
};
