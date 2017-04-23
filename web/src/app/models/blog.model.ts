export class Blog {

  public id: string;
  public title: string;
  public text: string;
  public date: Date;

  constructor(date: Date, id: string, text: string, title: string) {
    this.id = id;
    this.title = title;
    this.text = text;
    this.date = date;
  }
}
