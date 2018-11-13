import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TypeaheadModule } from 'ngx-bootstrap/typeahead';

@NgModule({
  imports: [
    CommonModule,
    TypeaheadModule.forRoot(),
  ],
  declarations: []
})
export class AppBootstrapModule { }
