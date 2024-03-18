import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';

import { AccountService } from '@app/_services';

@Component({ templateUrl: 'list.component.html' })
export class ListComponent implements OnInit {
    rulecodes?: any[];

    constructor(private accountService: AccountService) {}
    
    
    ngOnInit() {
       // debugger;
        this.accountService.getAll()
            .subscribe(rulecodes => this.rulecodes = rulecodes);
    }

    deleteRuleCode(id: string) {
        const user = this.rulecodes!.find(x => x.id === id);
        user.isDeleting = true;
        this.accountService.delete(id)
            .pipe(first())
            .subscribe(() => this.rulecodes = this.rulecodes!.filter(x => x.id !== id));
    }
}