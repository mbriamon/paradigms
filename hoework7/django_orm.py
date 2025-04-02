from polls.models import Question, Choice
from django.db.models import Sum
from datetime import datetime

# Q1.1: Retrieve all questions
all_questions = Question.objects.all()

# Q1.2: Retrieve all the choices for the question with a primary key of 1
choices_for_q1 = Choice.objects.filter(question_id=1)

# Q1.3: Retrieve all the questions published in 2023
questions_in_2023 = Question.objects.filter(pub_date__year=2023)

# Q1.4: Sum total number of votes for all choices for question ID = 1
total_votes = Choice.objects.filter(question_id=1).aggregate(Sum('votes'))['votes__sum']

# Q1.5: Retrieve all questions sorted by publication date in descending order
questions_desc_order = Question.objects.order_by('-pub_date')
