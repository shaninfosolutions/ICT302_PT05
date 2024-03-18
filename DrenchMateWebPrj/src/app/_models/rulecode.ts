export class RuleCodeDto{
    ruleCodeId?:number;
    code?:string;
    codeDesc?:string;
    remarks?:string;
}

export class RuleCodeValueDto{
    ruleCodeDto?:RuleCodeDto;
    code?:string;
    codeDesc?:string;
    codeValue?:number;
    remarks?:string;
}