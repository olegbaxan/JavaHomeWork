import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  private baseUrl = '/api/rest/person';
  constructor(private http: HttpClient) { }


  getAll(): Observable<any> {
    // return this.http.get('/api/rest/person');
    return this.http.get(this.baseUrl);
  }
  getById(id): Observable<any> {
    // return this.http.get('/api/rest/person/'+id);
    return this.http.get(`${this.baseUrl}/${id}`);

  }
  deletePerson(id){
    return  this.http.delete(`${this.baseUrl}?id=${id}`);
  }
  createPerson(person){
    return  this.http.post(this.baseUrl,person);
  }
  editPerson(id,person){
    return  this.http.put(`${this.baseUrl}?id=${id}`,person);
  }



  showTodayDate() {
    return new Date();
  }
}
