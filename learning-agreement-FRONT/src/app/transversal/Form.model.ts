import { User } from './User.model';
import { Course } from './Course.model';

export class Form {
    idForm: number;
    schoolYearStart: number;
    schoolYearEnd: number;
    semester: number;
    signatureDate: Date;
    rpi: User;
    partner: User;
    courses: Array<Course>;

    constructor(idForm: number, schoolYearStart: number, schoolYearEnd: number, semester: number, signatureDate: Date, rpi: User, partner: User, courses: Array<Course>) {
        this.idForm = idForm;
        this.schoolYearStart = schoolYearStart;
        this.schoolYearEnd = schoolYearEnd;
        this.semester = semester;
        this.signatureDate = signatureDate;
        this.rpi = rpi;
        this.partner = partner;
        this.courses = courses;
    }
}

export interface IForm {
    idForm: number;
    schoolYearStart: number;
    schoolYearEnd: number;
    semester: number;
    signatureDate: Date;
    rpi: User;
    partner: User;
    courses: Array<Course>;
}