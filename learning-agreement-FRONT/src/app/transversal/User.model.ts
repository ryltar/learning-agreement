export class User {
  idUser: number;
  idRole: number;
  lastName: string;
  firstName: string;
  birthDate: Date;
  mail: string;
  urlSignature: string;
  password: string;

  constructor(idUser: number, idRole: number, lastName: string, firstName: string, birthDate: Date, mail: string, urlSignature: string, password: string) {
    this.idUser = idUser;
    this.idRole = idRole;
    this.lastName = lastName;
    this.firstName = firstName;
    this.birthDate = birthDate;
    this.mail = mail;
    this.urlSignature = urlSignature;
    this.password = password;
  }
}

export interface IUser {
  idUser: number;
  idRole: number;
  lastName: string;
  firstName: string;
  birthDate: Date;
  mail: string;
  urlSignature: string;
  password: string;
}
