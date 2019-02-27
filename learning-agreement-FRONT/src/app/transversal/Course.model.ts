import { Form } from './Form.model';

export class Course {
    idCourse: number;
    titleCourse: string;
    nbrCredit: number;
    nbrEcts: number;

    constructor(idCourse: number, titleCourse: string, nbrCredit: number, nbrEcts: number) {
        this.idCourse = idCourse;
        this.titleCourse = titleCourse;
        this.nbrCredit = nbrCredit;
        this.nbrEcts = nbrEcts;
    }
}

export interface ICourse {
    idCourse: number;
    titleCourse: string;
    nbrCredit: number;
    nbrEcts: number;
}