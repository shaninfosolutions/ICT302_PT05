export class User {
    userId?: string;
    name?: string;
    token?: string;
    displayname?: string;
    message?: string;
    status?: string;
}

export class AuthRequest{
    email?:string;
    password?:string;
}

export class RegisterUser{
    userName?:string;
    email?:string;
    password?:string;
}

export class UserDto{
    userId?: number;
    name?: string;
    email?:string;
    password?:string;
    displayname?:string;
    avator?:string;
    phoneNo?:string;
    facebookLink?:string;
    twitterLink?:string;
    emialToNotify?:string;
    remarks?:string;
    status?:string;
}