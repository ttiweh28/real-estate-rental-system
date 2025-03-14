export type I_PropertyOwner = {
    id: number,
    firstName: string,
    lastName: string,
    username: string,
}

export type T_Property = {
    id: number,
    name: string,
    banner: string,
    images: string[],
    propertyOwner: I_PropertyOwner,
    location: string,
    price: string,
    isBooked: boolean,
    description: string,
    amenities: string[],
}

export type T_PropertyCreate = {
    name: string,
    banner: string,
    images: File[],
    location: string,
    price: string,
    description: string,
    amenities: string[],
}

export type T_PropertyEdit = {
    id: string;
    name: string;
    banner: string;
    images: (string | File) [];
    location: string;
    price: string;
    description: string;
    amenities: string[];
    // newImages: File[];
};