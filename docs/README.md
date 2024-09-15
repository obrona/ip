# Duch User Guide

### A ChatBot to manage your life

![alt text](./Ui.png)

Having trouble with all the endless tasks in your life ? Duch will manage them for you.

## Feature 1: Adding Deadline


You can add a deadline task. It is a special task that has a date, which is its deadline. The format of the date has to be in `DD/MM/YYYY hhmm`. Example: `12/02/2002 1800`.

Too add a deadline task, enter `deadline <description> /by <date>`

Example: `deadline hw /by 12/01/2002 1800`

If successful, Duch will acknowledge the creating of a new Deadline task

![alt text](./Deadline.png)

## Feature 2: Adding Todo

A todo task is simply a description of a task. There are no dates whatsover

To add a todo task, enter `todo <description>`,

Example: `todo cook dinner`

If successful, Duch will acknowledge the creation of a new Todo task

![alt text](./Todo.png)

## Feature 3: Adding Event

An event task is an event with a from and to date

To add a event task, enter `event <description> /from <date> /to <date>`

Example: `event rag day /from 12/01/2002 1200 /to 12/02/2002 1200`

If successful, Duch will acknowledge the creation of a new Event task

![alt text](./Event.png)

## Feature 5: List

By typing in `list`, Duch will display all your tasks for you

![alt text](./List.png)

## Feature 6: Mark and Unmark

Duch can help you mark and unmark events. First, get the index of the task using list, then type `mark <index of task>`. To unmark, simply type `unmark <index of task>`

If mark is successful, Duch will acknowledge it

![alt text](./Mark.png)

## Feature 7: Find

Duch can help you find tasks that contain a keywork. Simply type `find <keyword>` and Duch will list all tasks containing that keyword

![alt text](./Find.png)

If successful, Duch will acknowledge it



## Feature 8: Delete

Duch can help you delete tasks. Simply type `delete <index of task you want to delete>`

![alt text](./Delete.png)

## Feature 9: Undo

Duch can undo the last executed command, if you change your mind. Simply type `undo` and that is it. 

If the last executed command is one of `todo, deadline, even, mark, unmark, delete`, Duch will display the updated list of tasks. 

If the last executed task is one of `list, find`, Duch will only acknowledge the success of the command, but since there is no change to the tasks, Duch will not display the updated list of tasks.

## Important: To close Duch

To close Duch, type `bye`. Do not click `X` to close the window, otherwise Duch will not save your tasks