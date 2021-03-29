import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListEmployeeComponent} from './components/list-employee/list-employee.component';
import {AddEmployeeComponent} from './components/add-employee/add-employee.component';

const routes: Routes = [
  {path: 'employees', component: ListEmployeeComponent },
  {path: 'add', component: AddEmployeeComponent },
  {path: '', redirectTo: 'employees', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
