import requests
import csv
from collections import Counter

BASE_URL = 'http://jcssdev.pythonanywhere.com/'

def get_all_resources(resource):
    results = []
    url = f"{BASE_URL}{resource}"
    while url:
        response = requests.get(url)
        response.raise_for_status()
        data = response.json()
        results.extend(data['results'])
        url = data.get('next')
    return results

# Retrieve bugs and comments
bugs = get_all_resources('bugs')
comments = get_all_resources('comments')

# Generate total_bugs_per_package.csv
bug_counter = Counter(bug['package'] for bug in bugs)
with open('total_bugs_per_package.csv', 'w') as csvfile:
    writer = csv.writer(csvfile, quotechar='"', quoting=csv.QUOTE_MINIMAL)
    writer.writerow(['package', 'total'])
    for package, count in bug_counter.items():
        writer.writerow([package, count])


def extract_bug_id(bug_url):
    return int(bug_url.rstrip('/').split('/')[-1])

# Generate total_comments_per_bug.csv
comment_counter = Counter(extract_bug_id(comment['bug']) for comment in comments)

with open('total_comments_per_bug.csv', 'w') as csvfile:
    writer = csv.writer(csvfile, quotechar='"', quoting=csv.QUOTE_MINIMAL)
    writer.writerow(['bug_id', 'total'])
    for bug_id, count in comment_counter.items():
        writer.writerow([bug_id, count])
