export class Blog {

  public id: string;
  public title: string;
  public text: string;
  public date: Date;

  constructor(id: string, title: string, text: string, date: Date) {
    this.id = id;
    this.title = title;
    this.text = text;
    this.date = date;
  }
}
